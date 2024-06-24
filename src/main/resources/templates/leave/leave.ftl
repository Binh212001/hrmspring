<#import "../common/standerPage.ftl" as standerPage>

<@standerPage.Layout>
    <h3>My Leave</h3>
    <@standerPage.headerView
    to="/leave/create"
    searchUrl="/leave/search"
    ></@standerPage.headerView>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">
                Date
            </th>
            <th scope="col">
                Leave Type
            </th>
            <th scope="col">
                Date
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
        <tr>
            <th scope="row">1</th>
            <td>Request Time Off of Pham Ngoc Binh</td>
            <td>6</td>
            <td>6:00</td>
            <td>6:30</td>
            <td>Approved</td>
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
