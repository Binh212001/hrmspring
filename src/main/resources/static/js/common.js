$(document).ready(function () {
    // jQuery code to handle click event
    $('#hideMenu').click(function () {
        $("#sidebar-item").find("p[name]").each(function () {
            $(this).removeClass("show")
            $(this).addClass("hidden")
            $("#showMenu").css("display", "inline")
            $("#hideMenu").css("display", "none")
            $("#sidebar").css("width", "70px")
        });
        $("#sidebar-item  a").each(function () {
            $(this).addClass("text-center")
        })
    });

    $('#showMenu').click(function () {
        $("#sidebar-item").find("p[name]").each(function () {
            $(this).removeClass("hide")
            $(this).addClass("show");
            $("#hideMenu").css("display", "inline")
            $("#showMenu").css("display", "none")
            $("#sidebar").css("width", "100%")
            $(this).removeClass("text-center")
        });
        $("#sidebar-item  a").each(function () {
            $(this).removeClass("text-center")
        })
    });

    $("#leave-menu").click(function () {
        if ($("#leave-item").hasClass("hidden")) {
            $("#leave-item").addClass("show")
            $("#leave-item").removeClass("hidden")
        } else {
            $("#leave-item").addClass("hidden")
            $("#leave-item").removeClass("show")
        }
    })

    $("#overtime-menu").click(function () {
        if ($("#overtime-item").hasClass("hidden")) {
            $("#overtime-item").addClass("show")
            $("#overtime-item").removeClass("hidden")
        } else {
            $("#overtime-item").addClass("hidden")
            $("#overtime-item").removeClass("show")
        }
    })
    $("#shift-menu").click(function () {
        if ($("#shift-item").hasClass("hidden")) {
            $("#shift-item").addClass("show")
            $("#shift-item").removeClass("hidden")
        } else {
            $("#shift-item").addClass("hidden")
            $("#shift-item").removeClass("show")
        }
    })


    //Open Search employee  by Name
    $("#icon-search").click(function () {
        if($("#employee-search").hasClass("hidden")){
            $("#employee-search").addClass("show")
            $("#employee-search").removeClass("hidden")
        }else {
            $("#employee-search").addClass("hidden")
            $("#employee-search").removeClass("show")
        }
    })

    //Employee Sort
    $("#sort-up").click(function () {
        $(this).addClass("hidden")
        $("#sort-down").removeClass("hidden")
    })
    $("#sort-down").click(function () {
        $(this).addClass("hidden")
        $("#sort-up").removeClass("hidden")
    })

    //Show tab in create employee
    $("#edu-tab").click( function () {
        $("#tabList  a").removeClass("active")
        $("#edu-tab a").addClass("active")
        $("#other-tab-info").removeClass("show")
        $("#other-tab-info").addClass("hidden")
        $("#edu-tab-info").addClass("show")
        $("#edu-tab-info").removeClass("hidden")
    })
    $("#other-tab").click( function () {
        $("#tabList  a").removeClass("active")
        $("#other-tab a").addClass("active")
        $("#other-tab-info").removeClass("hidden")
        $("#other-tab-info").addClass("show")
        $("#edu-tab-info").addClass("hidden")
        $("#edu-tab-info").removeClass("show")
    })
});
