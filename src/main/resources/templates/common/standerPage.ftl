<#macro Layout >
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>${title!}</title>
        <link rel="stylesheet" href="/css/bootstrap.min.css">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
                integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="/js/common.js"></script>
        <script src="/js/employee.js"></script>
        <script src="/js/overtime.js"></script>
        <script src="/js/bootstrap.bundle.js "></script>
        <script src="/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/index.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
              integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
              crossorigin="anonymous" referrerpolicy="no-referrer"/>
    </head>
    <body class="max-height ">

    <div class="d-flex h-100">
        <header class="h-100 ">
            <nav class="position-relative  bg-light p-0 h-100 x " id="sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column" id="sidebar-item">
                        <img src="/images/logo.png" alt="logo" width="100%">
                        <li class="nav-item">
                            <a class="nav-link shadow-sm" href="/">
                                <i class="fa-solid fa-house"></i>
                                <p name="txt-link" class="show">
                                    Dashboard
                                </p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link shadow-sm" href="/employee">
                                <i class="fa-solid fa-user"></i>
                                <p name="txt-link" class="show">
                                    Employee
                                </p>
                            </a>
                        </li>
                        <li class="nav-item">
                        <span id="shift-menu"
                              class="d-flex justify-content-between align-items-center nav-link shadow-sm"
                              href="/work-shift">
                            <div>
                            <i class="fa-solid fa-calendar-days"></i>
                            <p name="txt-link" class="show">
                                Work Shift
                            </p>
                            </div>
                            <i class="fa-solid fa-chevron-down"></i>
                        </span>
                            <ul id="shift-item" class="list-style-none p-0 hidden">
                                <li class="shadow-sm px-4 py-2">
                                    <a href="/leave">My working shift</a>
                                </li>
                                <li class="shadow-sm px-4 py-2">
                                    <a href="/leave">All working shift</a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item">
                        <span id="overtime-menu"
                              class="d-flex justify-content-between align-items-center nav-link shadow-sm"
                              href="/overtime">
                            <div>
                        <i class="fa-solid fa-person-walking"></i>
                            <p name="txt-link" class="show">
                               Overtime
                            </p>
                            </div>
                            <i class="fa-solid fa-chevron-down"></i>
                        </span>
                            <ul id="overtime-item" class="list-style-none p-0 hidden">
                                <li class="shadow-sm px-4 py-2">
                                    <a href="/overtime">My Overtime </a>
                                </li>
                                <li class="shadow-sm px-4 py-2">
                                    <a href="/overtime">All Overtime</a>
                                </li>
                            </ul>
                        </li>
                        <li id="leave-menu" class="nav-item accordion accordion-flush accordion-button collapsed">
                        <span class="d-flex justify-content-between align-items-center nav-link shadow-sm">
                            <div>
                          <i class="fa-solid fa-person-walking-arrow-right"></i>
                            <p name="txt-link" class="show">
                               Leave
                            </p>
                            </div>
                             <i class="fa-solid fa-chevron-down"></i>
                        </span>
                            <ul id="leave-item" class="list-style-none p-0 hidden">
                                <li class="shadow-sm px-4 py-2">
                                    <a href="/leave">All leave</a>
                                </li>
                                <li class="shadow-sm px-4 py-2">
                                    <a href="/leave">My leave</a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link shadow-sm" href="/message">
                                <i class="fa-regular fa-comment"></i>
                                <p name="txt-link" class="show">
                                    Message
                                </p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link shadow-sm" href="/product">
                                <i class="fa-brands fa-product-hunt"></i>
                                <p name="txt-link" class="show">
                                    Product
                                </p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link shadow-sm" href="/order">
                                <i class="fa-solid fa-money-bills"></i>
                                <p name="txt-link" class="show">
                                    Orders
                                </p>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="text-center position-absolute btn-menu ">
                    <div class="navbar-toggler-icon">
                        <div id="showMenu" style="display: none">
                            <i class="fa-solid fa-chevron-right "></i>
                        </div>
                        <div id="hideMenu">
                            <i class="fa-solid fa-chevron-left"></i>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
        <div class="d-inline-block flex-1">
            <!-- Example single danger button -->
            <div class=" d-flex justify-content-end p-3 shadow-sm ">
                <div class="dropdown">
                    <img class="dropdown-toggle rounded-circle "
                         width="40px"
                         src="./images/avatar.jpg"
                         type="button"
                         id="dropdownMenuButton" data-toggle="dropdown"
                         aria-haspopup="true" aria-expanded="false"/>
                    <div class="dropdown-menu avt-dropdown "
                         aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item">Logout</a>
                    </div>
                </div>
            </div>
            <div class="px-5 py-3 scroll">
                <#nested />
            </div>
        </div>
    </div>
    </body>
    </html>
</#macro>
<#macro headerView
to=""
searchUrl = ""
>
    <form action="${searchUrl}" class=" mb-3 d-flex justify-content-between align-center align-items-center ">
        <a href="${to}" class="btn btn-primary" >New</a>
        <div class="d-flex align-items-center ">
            <input type="text" class="form-control" placeholder="Search">
            <span><i class="fa-solid fa-magnifying-glass"></i></span>
        </div>
    </form>
</#macro>

