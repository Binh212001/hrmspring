<#import "../common/standerPage.ftl" as standerPage>

<@standerPage.Layout>
    <h1 class="mt-5">Update Product</h1>
    <#if error??>
        <div class="alert alert-danger" role="alert">
            ${error!""}
        </div>
    </#if>
    <img src="/images/${product.image}">
    <form action="/product/edit/${product.id}" method="post" enctype="multipart/form-data" class="mt-3">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required value="${product.name}">
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" required
                   value="${product.price}">
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" name="description" required
                   value="${product.description}">
        </div>
        <div class="form-group">
            <label for="image">Image:</label>
            <input type="file" class="form-control-file" id="image" name="image" required>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" required
                   value="${product.quantity}">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</@standerPage.Layout>
