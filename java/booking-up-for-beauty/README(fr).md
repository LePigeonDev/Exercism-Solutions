# Réservation pour les soins de beauté

# Introduction

## Date-Time

La package `java.time` introduit dans Java 8 contient plusieurs classes pour travailler avec des dates et du temps.

### `LocalDate`

La classe `java.time.LocalDate` represente une date sans le temps de la région dans le format [ISO-8601 calendar system][iso-8601], comme `2007-12-03`:

```java
LocalDate date = LocalDate.of(2007, 12, 3);
```

Les dates peuvent être comparé avec d'autres dates:

```java
LocalDate date1 = LocalDate.of(2007, 12, 3);
LocalDate date2 = LocalDate.of(2007, 12, 4);

date1.isBefore(date2);
// => true

date1.isAfter(date2);
// => false
```

Une instance `LocalDate` à des getters pour retrouver les portions de temps de celui-ci:

```java 
LocalDate date = LocalDate.of(2007, 12, 3);

date.getDayOfMonth();
// => 3
```

Une instance `LocalDate` à une méthode pour ajouter des unités de temps à celui-ci:

```Note
Ces méthodes retourne une nouvelle instance de `LocalDate` et ne met pas à jour l'instance existante, comme la classe `LocalDate` est immutable.
```

```java
LocalDate date = LocalDate.of(2007, 12, 3);

date.plusDays(3);
// => 2007-12-06
```

### `LocalDateTime`

La classe `java.time.LocalDateTime` représente un date-time sans le time zone dans le [ISO-8601 calendar system][iso-8601], tel que `2007-12-03T10:15:30`:

```java
LocalDateTime datetime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
```

Vous pouvez convertir l'instance `LocalDate` en `LocalDateTime`:

```java
LocalDate date = LocalDate.of(2007, 12, 3);
LocalDateTime dateTime = data.atTime(10, 15, 30);
dateTime.toString();
// => "2007-12-03T10:15:30"
```

### Formatting dateTimes

`LocalDate` et `LocalDateTime` utise tout deux le standard de notation [ISO-8601][iso-8601] quand il faut convertir depuis et vers un `String`.

```java
LocalDateTime datetime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
LocalDateTime parsed = LocalDateTime.parse("2007-12-03T10:15:30");

datetime.isEqual(parsed);
// => true
```

Tentative de convertir `LocalDate` ou `LocalDateTime` en `String` comme ceci utiliser des differents format n'est pas possible.
Plutôt, le format date utilise un format modifié, vous devrez utilisé le `java.time.format.DateTimeFormatter`:

```java
DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate date = LocalDate.parse("03/12/2007", parser);

DateTimeFormatter printer = DateTimeFormatter.ofPattern("MMMM d, yyyy");
printer.format(date);
// => "December 3, 2007"
```


## Instructions

Dans cette exercice vous devrez travailler sur un planificateur de rendez-vous pour un salon de beauté dans New York qui a ouvert le 15 Septembre 2012.

## 1. Convertir en date de rendez vous 

Implémenter la méthode `AppointmentScheduler.schedule()` pour convertir une représentation textuelle d'une date de rendez-vous en `LocalDateTime` :

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.schedule("7/25/2019 13:45:00");
// => LocalDateTime.of(2019, 7, 25, 13, 45, 0)
```

## 2. Verifier si la date de rendez-vous est déjà passé

implementer la méthode `AppointmentScheduler.hasPassed()` pour que ça prenne une date de rendez vous et que ca vérifie si le rendez vous est deja passé:

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.hasPassed(LocalDateTime.of(1999, 12, 31, 9, 0, 0));
// => true
```

## 3. Vérifier si la date de rendez vous est dans l'après midi

Implémenter la méthode `AppointmentScheduler.isAfternoonAppointment()` pour prendre un rendez vous et vérifier si le rendez vous est dans une après midi (=>12:00 and < 18:00):

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.isAfternoonAppointment(LocalDateTime.of(2019, 03, 29, 15, 0, 0))
// => true
```

## 4. Décrire le temps et la date du rendez vous

Implémenter la méthode `AppointmentScheduler.getDescription()` pour prendre une date de rendez vous et retourner la description de la date et du temps :

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.getDescription(LocalDateTime.of(2019, 03, 29, 15, 0, 0))
// => "You have an appointment on Friday, March 29, 2019, at 3:00 PM."
```

## 5. Retourner la date d'anniversaire

Implémenter la méthode `AppointmentScheduler.getAnniversaryDate()` pour que ca retourne la date d'anniversaire de cette année soit le 15 septembre.

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.getAnniversaryDate()
// => LocalDate.of(<current year>, 9, 15)
```