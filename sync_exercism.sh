#!/usr/bin/env bash
set -euo pipefail

### ================== CONFIG PAR DÉFAUT ==================
# Emplacement de ton workspace Exercism (modifie si besoin)
EXERCISM_DIR="${EXERCISM_DIR:-$HOME/Exercism}"

# Dossier local de ton repo GitHub qui contiendra toutes tes solutions
REPO_DIR="${REPO_DIR:-$HOME/GitHub/Exercism-Solutions}"

# Branche Git à utiliser
BRANCH="${BRANCH:-main}"

# URL du dépôt GitHub (ex: https://github.com/<user>/Exercism-Solutions.git)
ORIGIN_URL="${ORIGIN_URL:-}"

# Message de commit par défaut
COMMIT_MSG="${COMMIT_MSG:-Mise à jour Exercism}"

# Dry-run (voir ce qui serait copié sans rien écrire) : "true" ou "false"
DRY_RUN="${DRY_RUN:-false}"
### =======================================================

usage() {
  cat <<EOF
Usage:
  EXERCISM_DIR=~/Exercism REPO_DIR=~/GitHub/Exercism-Solutions ORIGIN_URL=https://github.com/<user>/Exercism-Solutions.git $0

Variables env utiles:
  EXERCISM_DIR   : chemin du workspace Exercism (défaut: ~/Exercism)
  REPO_DIR       : dossier du dépôt local (défaut: ~/GitHub/Exercism-Solutions)
  ORIGIN_URL     : URL du dépôt GitHub (obligatoire au premier run)
  BRANCH         : branche (défaut: main)
  COMMIT_MSG     : message de commit (défaut: "Mise à jour Exercism")
  DRY_RUN        : true/false (défaut: false)
EOF
}

# Vérifs basiques
if [[ ! -d "$EXERCISM_DIR" ]]; then
  echo "❌ EXERCISM_DIR n'existe pas: $EXERCISM_DIR"
  exit 1
fi

mkdir -p "$REPO_DIR"

# Init repo si besoin
if [[ ! -d "$REPO_DIR/.git" ]]; then
  echo "📦 Initialisation du dépôt Git dans $REPO_DIR"
  git -C "$REPO_DIR" init -b "$BRANCH"
  # .gitignore de base
  if [[ ! -f "$REPO_DIR/.gitignore" ]]; then
    cat > "$REPO_DIR/.gitignore" <<'GITIGNORE'
# Ignorer les dossiers internes d'Exercism
**/.exercism/
# Fichiers temporaires/IDE
.DS_Store
*.log
.idea/
.vscode/
# Binaires / builds
target/
bin/
obj/
dist/
build/
GITIGNORE
  fi
  # README minimal
  if [[ ! -f "$REPO_DIR/README.md" ]]; then
    cat > "$REPO_DIR/README.md" <<'README'
# Exercism Solutions

Ce dépôt agrège mes solutions Exercism classées par langage et par exercice.
Arborescence : `langage/exercice`.

README
  fi
fi

# Définir origin si manquant
if ! git -C "$REPO_DIR" remote get-url origin &>/dev/null; then
  if [[ -z "$ORIGIN_URL" ]]; then
    echo "❌ ORIGIN_URL est requis au premier run (ex: https://github.com/<user>/Exercism-Solutions.git)"
    usage
    exit 1
  fi
  echo "🔗 Ajout du remote origin: $ORIGIN_URL"
  git -C "$REPO_DIR" remote add origin "$ORIGIN_URL"
fi

# S’assurer qu’on est sur la bonne branche
git -C "$REPO_DIR" checkout -B "$BRANCH"

# Options rsync (copie rapide, respecte timestamps, supprime ce qui a été supprimé côté Exercism)
RSYNC_FLAGS=(-a --delete --prune-empty-dirs)
# Exclusions (dossiers internes Exercism)
EXCLUDES=(--exclude ".exercism/")

if [[ "$DRY_RUN" == "true" ]]; then
  RSYNC_FLAGS+=(--dry-run --itemize-changes)
  echo "🧪 DRY-RUN activé: aucune écriture ne sera faite."
fi

echo "📥 Synchronisation depuis $EXERCISM_DIR vers $REPO_DIR ..."
rsync "${RSYNC_FLAGS[@]}" "${EXCLUDES[@]}" "$EXERCISM_DIR/""/" "$REPO_DIR/"

# Ajout/commit/push si changements
if ! git -C "$REPO_DIR" diff --quiet || ! git -C "$REPO_DIR" diff --cached --quiet; then
  git -C "$REPO_DIR" add -A
  git -C "$REPO_DIR" commit -m "$COMMIT_MSG" || true

  if [[ "$DRY_RUN" == "false" ]]; then
    echo "🚀 Push vers origin/$BRANCH ..."
    # Première fois : crée la branche distante si besoin
    git -C "$REPO_DIR" push -u origin "$BRANCH"
  else
    echo "🧪 DRY-RUN: push sauté."
  fi
else
  echo "✅ Rien à commit (dépôt déjà à jour)."
fi

echo "✨ Terminé."
