<#import "../common/standerPage.ftl" as standerPage>

<@standerPage.Layout>
    <h3>My Leave</h3>
    <@standerPage.headerView
    to="${newLeave}"
    searchUrl="/leave/search"
    refusedUrl="/leave/refused"
    approvedUrl="/leave/approved"
    ></@standerPage.headerView>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col" class="text-center">
                <input type="checkbox" id="checkAll"/>
            </th>
            <th scope="col">Title</th>
            <th scope="col">
                Date
            </th>
            <th scope="col">
                Leave Type
            </th>

            <th scope="col">
                reason
            </th>
            <th scope="col">
                Status
            </th>
        </tr>
        </thead>
        <tbody>
        <#list  leave as l>
            <tr>
                <th scope="row" class="text-center">
                    <input type="checkbox" name="id" value="${l.leaveId!''}"/>
                </th>
                <td>Request Time Off of ${l.employee.fullName}</td>
                <td>${l.date!""}</td>
                <td>${l.type!""}</td>
                <td>${l.reason!""}</td>
                <td> ${l.status!"DRAFT"}</td>
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
