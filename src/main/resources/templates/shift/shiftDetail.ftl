<#import "../common/standerPage.ftl" as standerPage>

<@standerPage.Layout>
    <h2>Attendance Records of ${attendances.employee.fullName} on ${attendances.month}/${attendances.year}</h2>
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Day of week</th>
            <th scope="col">Date</th>
            <th scope="col">Check-In Time</th>
            <th scope="col">Check-Out Time</th>
            <th scope="col">Working Hours</th>
            <th scope="col">Overtime Hours</th>
        </tr>
        </thead>
        <tbody>
        <#if attendances.attendanceItems??>
            <#list attendances.attendanceItems as item>
                <tr class="<#if item.dayOfWeek=="SAT"|| item.dayOfWeek=="SUN">text-white bg-success</#if>">
                    <td>${item.dayOfWeek!""}</td>
                    <td>${item.date!""}</td>
                    <td>${item.checkInTime!""}</td>
                    <td>${item.checkOutTime!""}</td>
                    <td>${item.workingHours!""}</td>
                    <td>${item.overtimeHours!""}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@standerPage.Layout>
