<#import "../common/standerPage.ftl" as standerPage>

<@standerPage.Layout>
    <h3><#if mode == "0">New Overtime<#else>Update overtime</#if></h3>
    <div>
        <button id="btnSave" class="btn  <#if mode == "0"> btn-primary  <#else>  btn-success </#if>">
            <#if mode == "0"> Save<#else>Edit</#if>
        </button>
    </div>
    <input id="mode" value="${mode}" hidden />
    <form id="overtimeForm" class="row">
        <div class="form-group col-6">
            <label for="employeeId">Employee</label>
            <select class="form-control" id="employeeId" name="employeeId">
                <option value="1">Binh</option>
            </select>
        </div>
        <div class="form-group col-6">
            <label for="id">Date</label>
            <input type="date" class="form-control" id="date" name="date"
                   <#if mode == "1">value="${overtime.date?string('yyyy-MM-dd')}"</#if>/>
        </div>
        <div class="form-group col-6">
            <label for="id">Start time</label>
            <input type="time" class="form-control" id="startTime" name="startTime"
                   <#if mode == "1">value="${overtime.date?string('yyyy-MM-dd')}"</#if>/>
        </div>
        <div class="form-group col-6">
            <label for="id">End Time</label>
            <input type="time" class="form-control" id="endTime" name="endTime"
                   <#if mode == "1">value="${overtime.date?string('yyyy-MM-dd')}"</#if>/>
        </div>
    </form>

</@standerPage.Layout>
