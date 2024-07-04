<#import "../common/standerPage.ftl" as standerPage>
<@standerPage.Layout>
    <@standerPage.headerView
    to="${newEmployee}"
    searchUrl="/leave/search"
    ></@standerPage.headerView>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">First Name</th>
            <th scope="col">
                <span>Last Name</span>
                <i id="icon-search" class="fa-solid fa-magnifying-glass float-right mt-1">
                </i>
                <div id="employee-search" class="hidden">
                    <form method="post" action="/employee" class="position-absolute   d-flex">
                        <input type="text" class="form-control" id="firstName" name="firstName" required>
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
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>John</td>
            <td>Doe</td>
            <td>1990-01-01</td>
            <td>Male</td>
            <td>john.doe@example.com</td>
            <td>0987272867</td>
            <td>123 Main St</td>
            <td>2020-06-01</td>
            <td>IT</td>
            <td>Developer</td>
        </tr>
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
