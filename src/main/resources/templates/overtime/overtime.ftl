<#import "../common/standerPage.ftl" as standerPage>
<@standerPage.Layout>
    <h3>My Overtime</h3>
    <@standerPage.headerView
    to="${newOvertime}"
    searchUrl="/overtime/search"
    approvedUrl="/overtime/approved"
    refusedUrl="/overtime/refused"
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
                Start Time
            </th>
            <th scope="col">
                End Time
            </th><th scope="col">
             Duration
            </th>
            <th scope="col">
                Status
            </th>
        </tr>
        </thead>
        <tbody>
        <#list  overtime as ot>
            <tr>
                <th scope="row " class="text-center">
                    <input type="checkbox" name="id" value="${ot.overtimeId!''}"/>
                </th>
                <td>Request OT of ${ot.employee.fullName}</td>
                <td>${ot.date}</td>
                <td>${ot.startTime}</td>
                <td>${ot.endTime}</td>
                <td>${ot.duration}</td>
                <td>${ot.status!"DRAFT"}</td>
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
