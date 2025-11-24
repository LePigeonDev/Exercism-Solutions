class Badge {
    public String print(Integer id, String name, String department) {
        String idString = "";
        if (id != null) {
            idString = "[" + id + "] - ";
        }
        if (department == null) {
            department = "OWNER";
        } 
        
        return idString + name + " - " + department.toUpperCase();
    }
}
