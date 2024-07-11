<#import "../common/standerPage.ftl" as standerPage>

<@standerPage.Layout>
    <h1 class="mt-5">Add Product</h1>
    <form action="/product/new" method="post" enctype="multipart/form-data" class="mt-3">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" name="description" required>
        </div>
        <div class="form-group">
            <label for="image">Image:</label>
            <input type="file" class="form-control-file" id="image" name="image" required>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" required>
        </div>
        <input name="_csrf" type="hidden" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Add Product</button>
    </form>
</@standerPage.Layout>
