const inputs = document.querySelectorAll(".input");


function addcl() {
    let parent = this.parentNode.parentNode;
    parent.classList.add("focus");
}

function remcl() {
    let parent = this.parentNode.parentNode;
    if (this.value == "") {
        parent.classList.remove("focus");
    }
}


inputs.forEach(input => {
    input.addEventListener("focus", addcl);
    input.addEventListener("blur", remcl);
});


$(document).ready(function () {
    // $("#btnLogin").click(function () {
    //     let loginSerialize = $("#loginForm").serializeArray()
    //     let loginForm = {};
    //     loginSerialize.map(function (data) {
    //         loginForm[data.name] = data.value
    //     })
    //     $.ajax({
    //         url: window.origin + "/auth/login",
    //         type: "POST",
    //         contentType: "application/json",
    //         data: JSON.stringify(loginForm),
    //         success: function (response) {
    //             console.log(response)
    //             if (response) {
    //                 localStorage.setItem("token", response.token)
    //                 let origin = window.origin;
    //                 window.location.href = `${origin}/home`
    //             }
    //         },
    //         error: function (xhr, status, error) {
    //             alert("Invalid username or password!")
    //         }
    //     })
    // })

})