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



    $("#checkAll").change(function () {
        const checkedAll = $("#checkAll").prop("checked");
        if (checkedAll) {
            $('input[name="id"]').each(function () {
                $("#btnApproved").addClass("show")
                $("#btnApproved").removeClass("hidden")
                $("#btnRefused").addClass("show")
                $("#btnRefused").removeClass("hidden")
                $(this).prop("checked", true)
            });
        } else {
            $('input[name="id"]').each(function () {
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
                $("#btnRefused").addClass("hidden")
                $("#btnRefused").removeClass("show")
                $(this).prop("checked", false)
            });
        }
    })

    $("#btnApproved").click(function () {
        let approveData = []
        let url = $(this).attr("approvedUrl")
        $('input[name="id"]').each(function () {
            if ($(this).prop("checked")) {
                approveData.push($(this).val())
            }
        });
        approved(approveData,url)
    })

    $("#btnRefused").click(function () {
        let refusedData = []
        let url = $(this).attr("refusedUrl")
        $('input[name="id"]').each(function () {
            if ($(this).prop("checked")) {
                refusedData.push($(this).val())
            }
        });
        refuse(refusedData,url)
    })

    function refuse(refusedData,url) {
        $.ajax({
            url:url,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(refusedData),
            success: function (response) {
                alert(response.message)
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
                $("#btnRefused").addClass("hidden")
                $("#btnRefused").removeClass("show")
                location.reload()
            },
            error: function (xhr, status, error) {
                $("#messageFail").text("Request approved is fail.");
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
                $("#btnRefused").addClass("hidden")
                $("#btnRefused").removeClass("show")
            }
        });
    }

    function approved(approveData,url) {
        $.ajax({
            url:url,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(approveData),
            success: function (response) {
               alert(response.message)
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
                location.reload()
            },
            error: function (xhr, status, error) {
                $("#messageFail").text("Request approved is fail.");
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
            }
        });
    }

    $('input[name="id"]').each(function () {
        $(this).change(function () {
            if ($('input[name="id"]:checked').length > 0) {
                $("#btnApproved").addClass("show")
                $("#btnApproved").removeClass("hidden")
                $("#btnRefused").addClass("show")
                $("#btnRefused").removeClass("hidden")
            } else {
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
                $("#btnRefused").addClass("hidden")
                $("#btnRefused").removeClass("show")
            }
        })
    })
});
