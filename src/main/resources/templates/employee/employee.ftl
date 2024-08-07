<#import "../common/standerPage.ftl" as standerPage>
<@standerPage.Layout>
    <@standerPage.headerView
    to="${newEmployee}"
    searchUrl="/employee/search"
    ></@standerPage.headerView>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">
                <span>Full Name</span>
                <i id="icon-search" class="fa-solid fa-magnifying-glass float-right mt-1">
                </i>
                <div id="employee-search" class="hidden">
                    <form method="get" action="/employee/search" class="position-absolute   d-flex">
                        <input type="text" class="form-control" id="keyword" name="keyword" required>
                        <button type="submit" class="bg-white border-0 rounded">
                            <i class="fa-solid fa-magnifying-glass float-right mt-1"></i>
                        </button>
                    </form>
                </div>
            </th>
            <th scope="col">Date of Birth</th>
            <th scope="col">Gender</th>
            <th scope="col">
                Phone
            </th>
            <th scope="col">Phone</th>
            <th scope="col">Address</th>
            <th scope="col">
                Hire Date
                <span id="sort-up" class="float-right hidden "><i class="fa-solid fa-sort-up"></i></span>
                <span id="sort-down" class="float-right "><i class="fa-solid fa-sort-down"></i></span>
            </th>
            <th scope="col">Department</th>
            <th scope="col">Position</th>
        </tr>
        </thead>
        <tbody id="employeeData">
        <#list employees as e>
            <tr data-id="${e.employeeId!""}">
                <th scope="row" >${e.employeeId!""}
                </th>
                <td>${e.fullName!""}</td>
                <td>${e.dateOfBirth!""}</td>
                <td>${e.gender!""}</td>
                <td>${e.email!""}</td>
                <td>${e.phone!""}</td>
                <td>${e.address!""}</td>
                <td>${e.hireDate!""}</td>
                <td>
                    <#if e.department ??>
                        ${e.department.departmentName!""}
                    </#if>
                </td>
                <td>
                    <#if e.position ??>
                        ${e.position.positionName!""}
                    </#if>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</@standerPage.Layout>
