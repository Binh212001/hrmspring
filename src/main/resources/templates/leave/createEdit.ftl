<#import "../common/standerPage.ftl" as standerPage>
<@standerPage.Layout>
    <h3><#if mode == "0">New Leave<#else>Update leave</#if></h3>
    <div>
        <button id="btnSaveLeave" class="btn  <#if mode == "0"> btn-primary  <#else>  btn-success </#if>">
            <#if mode == "0"> Save<#else>Edit</#if>
        </button>
    </div>
    <input id="mode" value="${mode}" hidden />
    <form id="leaveForm" class="row">
        <div class="form-group col-6">
            <label for="employeeId">Employee</label>
            <select class="form-control" id="employeeId" name="employeeId">
                <option value="1">Binh</option>
            </select>
        </div>
        <div class="form-group col-6">
            <label for="employeeId">Type</label>
            <select class="form-control" id="type" name="type">
                <option value="1">Binh</option>
            </select>
        </div>
        <div class="form-group col-6">
            <label for="id">Date</label>
            <input type="date" class="form-control" id="date" name="date"
                   <#if mode == "1">value="${leave.date?string('yyyy-MM-dd')}"</#if>/>
        </div>
        <div class="form-group col-6">
            <label for="reason">Reason</label>
            <input type="text" class="form-control" id="reason" name="reason"
                   <#if mode == "1">value="${leave.reason}"</#if>/>
        </div>
    </form>

</@standerPage.Layout>
