<#import "../common/standerPage.ftl" as standerPage>

<@standerPage.Layout>

    <h1>Products</h1>
    <#if message??>
    <div class="alert alert-info" role="alert">
     ${message!""}
    </div>
    </#if>
    <table class="table table-bordered table-striped mt-3">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Image</th>
            <th>Quantity</th>
        </tr>
        </thead>
        <tbody>
        <#list products as product>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td><img src="/images/${product.image}" alt="${product.name}" width="50" height="50"></td>
                <td>${product.quantity}</td>
            </tr>
        </#list>
        </tbody>
    </table>

    <nav aria-label="Page navigation">
        <ul class="pagination">
            <#if (currentPage>0) >
                <li class="page-item">
                    <a class="page-link" href="/products/paginated?page=${currentPage - 1}&size=10"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </#if>
            <#if (totalPages>10)>
                <#list currentPage..(currentPage+3) as i>
                    <li class="page-item <#if currentPage == i>active</#if>">
                        <a class="page-link" href="/products/paginated?page=${i}&size=10">${i + 1}</a>
                    </li>
                </#list>
                <li class="page-item">
                    ...
                </li>

                <#list totalPages..(totalPages-3) as i>
                    <li class="page-item <#if currentPage == i>active</#if>">
                        <a class="page-link" href="/products/paginated?page=${i}&size=10">${i + 1}</a>
                    </li>
                </#list>

            <#else >
                <#list 0..totalPages-1 as i>
                    <li class="page-item <#if currentPage == i>active</#if>">
                        <a class="page-link" href="/products/paginated?page=${i}&size=10">${i + 1}</a>
                    </li>
                </#list>
            </#if>
            <#if currentPage + 1 < totalPages>
                <li class="page-item">
                    <a class="page-link" href="/products/paginated?page=${currentPage + 1}&size=10"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </#if>
        </ul>
    </nav>
</@standerPage.Layout>
