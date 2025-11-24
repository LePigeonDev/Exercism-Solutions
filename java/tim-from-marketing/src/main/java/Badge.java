class Badge {
    public String print(Integer id, String name, String department) {
        String departmentName =" ";
        String idString = "";
        if (id != null) {
            idString = "[" + id + "] - ";
        }
        if (department == null) {
            departmentName = "OWNER";
        } else {
            departmentName = department.toUpperCase();
        }

        return idString + name + " - " + departmentName;
    }
}
