$(document).ready(function () {
    $("#saveEmployee").click(function () {
        let employeeSerialize = $("#employeeForm").serializeArray()
        let mode = $("#mode").val();
        let employeeForm = {};
        employeeSerialize.map(function (data) {
            employeeForm[data.name] = data.value
        })
        let id = $("#id").val();
        employeeForm["id"]=id
        $.ajax({
            url: mode == 0 ? "/employee/save" : "/employee/edit",
            type: mode == 0 ? "POST" : "PUT",
            contentType: "application/json",
            data: JSON.stringify(employeeForm),
            success: function (response) {
                console.log(response)
                window.location.href = "http://localhost:8080/employee";
            },
            error: function (xhr, status, error) {
                console.error("Error: " + status + " " + error.getMessage());
            }
        });
    })
});
