import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<String, String> attributes;
    private final List<Node> nodes;
    private final List<Edge> edges;

    public Graph() {
        this.attributes = Collections.emptyMap();
        this.nodes = List.of();
        this.edges = List.of();
    }

    public Graph(Map<String, String> attributes) {
        this.attributes = Map.copyOf(attributes);
        this.nodes = List.of();
        this.edges = List.of();
    }

    private Graph(Map<String, String> attributes, List<Node> nodes, List<Edge> edges) {
        this.attributes = attributes;
        this.nodes = nodes;
        this.edges = edges;
    }

    public Collection<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public Collection<Edge> getEdges() {
        return Collections.unmodifiableList(edges);
    }

    public Graph node(String name) {
        return node(name, Collections.emptyMap());
    }

    public Graph node(String name, Map<String, String> attributes) {
        Node node = new Node(name, attributes);

        List<Node> newNodes = new ArrayList<>(this.nodes);
        newNodes.add(node);

        return new Graph(this.attributes, List.copyOf(newNodes), this.edges);
    }

    public Graph edge(String start, String end) {
        return edge(start, end, Collections.emptyMap());
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {
        Edge edge = new Edge(start, end, attributes);

        List<Edge> newEdges = new ArrayList<>(this.edges);
        newEdges.add(edge);

        return new Graph(this.attributes, this.nodes, List.copyOf(newEdges));
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
