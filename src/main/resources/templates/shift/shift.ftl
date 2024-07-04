<#import "../common/standerPage.ftl" as standerPage>

<@standerPage.Layout>
    <h3>My Attendance</h3>
    <div class="mb-2 ">
        <button class="btn btn-success hidden" id="btnApproved">Approved</button>
    </div>
    <div>
        <p id="message" class="text-primary bold"></p>
        <p id="messageFail" class="text-danger bold"></p>
    </div>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col" class="text-center">
                <input type="checkbox" id="checkAll"/>
            </th>
            <th scope="col">Title</th>
            <th scope="col">
                Month
            </th>
            <th scope="col">
                Year
            </th>
            <th scope="col">
                Status
            </th>
        </tr>
        </thead>
        <tbody>
        <#list  attendances as attend>
            <tr>
                <th scope="row" class="text-center">
                    <input type="checkbox" name="attendanceId" value="${attend.attendanceId!""}"/>
                </th>
                <td>Attendance of ${attend.employee.fullName} on ${attend.month!""}/${attend.year!""} </td>
                <td>${attend.month!""}</td>
                <td>${attend.year!""}</td>
                <td class="text-center">
                <span class="badge <#if attend.status?? && attend.status == "APPROVED">text-bg-success<#else>text-bg-secondary</#if>">
                    ${attend.status!"DRAFT"}
                </span>
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
