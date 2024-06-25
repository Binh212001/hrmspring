$(document).ready(function () {
    $("#saveEmployee").click(function () {
        let employeeSerialize = $("#employeeForm").serializeArray()
        let employeeForm = {};
        employeeSerialize.map(function (data) {
            employeeForm[data.name] = data.value
        })
        $.ajax({
            url: "/employee/save",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(employeeForm),
            success: function(response) {
                // $.toast(response.message)
                window.location.href = "http://localhost:8080/employee";
            },
            error: function(xhr, status, error) {
                console.error("Error: " + status + " " + error.getMessage());
            }
        });
    })
});
