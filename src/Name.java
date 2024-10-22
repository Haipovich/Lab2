public class Name {
    private String last_name;
    private String first_name;
    private String middle_name;

    public Name(String last_name, String first_name, String middle_name) {
        if ((last_name == null || last_name.isEmpty()) && (first_name == null || first_name.isEmpty())) {
            throw new IllegalArgumentException("Name or surname must not be null");
        }
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
    }

    public Name(String last_name, String first_name) {
        this(last_name, first_name, null);
    }

    public Name(String first_name) {
        this(null, first_name, null);
    }

    @Override
    public String toString() {
        String result = "";
        if (last_name != null && !last_name.isEmpty()) {
            result += last_name + " ";
        }
        if (first_name != null && !first_name.isEmpty()) {
            result += first_name + " ";
        }
        if (middle_name != null && !middle_name.isEmpty()) {
            result += middle_name;
        }
        return result.trim();
    }
}