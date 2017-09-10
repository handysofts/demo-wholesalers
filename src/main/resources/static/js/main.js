/**
 * Created by progr on 2017-08-02.
 */

$(document).ready(function () {

    $('#calculatePriceButton').click(function () {
        var selectedCustomer = $('#customer').val();
        if (selectedCustomer < 1) {
            alert("Please select customer.");
            return;
        }

        var selectedProduct = $('#product').val();
        if (selectedProduct < 1) {
            alert("Please select product.");
            return;
        }

        var quantity = $('#quantity').val();
        if (quantity < 1) {
            alert("Please enter quantity.");
            return;
        }


        $('#alertBox').hide();
        var form = $('#calculatePriceForm');
        $.ajax({
            type: "GET",
            url: form.attr('action').replace("customerId", selectedCustomer).replace("productId", selectedProduct).replace("quantityVal", quantity),
            success: function (response) {
                console.log(response);
                if (response.error == undefined){
                    alert("Unknown error occurred! Please contact to developer.")
                    return;
                }
                if (response.error.code != 0){
                    alert(response.error.message);
                    return;
                }

                $('#resultPanel').html('');
                $('#resultPanel').append('<strong>Product: </strong>'+response.price.product.name+"<br/>");
                $('#resultPanel').append('<strong>Price: </strong>'+response.price.product.price+"<br/>");
                $('#resultPanel').append('<strong>Discount: </strong>'+response.price.discount+"<br/>");
                $('#resultPanel').append("<hr />");
                $('#resultPanel').append('<strong>Total: </strong>'+response.price.total);
                // $('#resultPanel').append('<strong>Total: </strong>'+(response.price.product.price*quantity-response.price.discount).toFixed(2));
            },
            error: function (request, status, error) {
                alert(request.responseText);
            }
        });
    });

});


function alert(msg) {
    $('#messageBox').html('<strong>Error!</strong> ' + msg);
    $('#alertBox').show();
}