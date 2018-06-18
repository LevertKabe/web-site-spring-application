var pnpModule = angular.module("pnpModule", []);

pnpModule.controller("ProductController",function($scope,$http)
{
    $http.defaults.headers.post["Content-Type"] = "application/json";
    
    $http.get("http://localhost:8181/getProducts").then(function(response)
    {
        console.log(response.data);
        $scope.products = response.data;
    });
    
    $http.get("http://localhost:8181/getAllOrders").then(function(response)
    {
        console.log(response.data);
        $scope.orders = response.data;
    });
    
    $http.get("http://localhost:8181/getCustNoAdmin").then(function(response)
    {
        console.log(response.data);
        $scope.allCustomer = response.data;
    });
    
    $http.get("http://localhost:8181/getCategory").then(function(response)
    {
        console.log(response.data);
        $scope.category = response.data;
    });
    
    $http.get("http://localhost:8181/user").then(function(response)
    {
        console.log(response.data);
        $scope.user = response.data;
    });
    
    $http.get("http://localhost:8181/getId").then(function(response)
    {
        console.log(response.data);
        $scope.userDetails = response.data;
    });
    
    $http.get("http://localhost:8181/viewCart").then(function(response)
    {
        $scope.cart=0;
        $scope.cart=response.data;
        
  
        var num = 0;
        
        var ID = $scope.userDetails[0].custID;
        var name = $scope.cart.custID;
        $scope.orderCart = [];
        $scope.cartProducts = [];
        $scope.realCart = [];
        var counter = 0;
        console.log($scope.cart);
        var hasCart = 0;
        var howMany = 0;

        for (var u = 0 ; u < $scope.cart.length  ; u++ )
        {
           console.log($scope.cart[u]);
           console.log($scope.userDetails[0].custID);
           
           if($scope.cart[u].custID == ID)
           {
               console.log($scope.userDetails[0].custID);
               
               
               $scope.realCart[howMany] = $scope.cart[u].barcode;
               howMany = howMany + 1;
               hasCart = 1;
               
               $http.get("http://localhost:8181/getProducts").then(function(response)
                { 
                    $scope.product = response.data;
                    console.log($scope.product);
                             for(var i = 0 ; i < $scope.product.length  ; i++)
                             {
                                if($scope.product[i].barcode == $scope.realCart[counter])
                                {
                                    $scope.cartProducts[num] = $scope.product[i];
                                    num++;
                                    counter = counter + 1;
                                }
                             }
                        });
                /*for(var k = 0 ; k < $scope.cart.length   ; k++ )
                {    
                    $scope.orderCart[k] = $scope.cart[k];
                    var varProd = $scope.orderCart[k];
                    
                        $http.get("http://localhost:8181/getProducts").then(function(response)
                        { 
                             $scope.product = response.data;
                             console.log($scope.product);
                             for(var i = 0 ; i < $scope.product.length  ; i++)
                             {
                                if($scope.product[i].barcode == $scope.orderCart[counter].barcode )
                                {
                                    $scope.cartProducts[num] = $scope.product[i];
                                    num++;
                                    counter = counter + 1;
                                }
                             }
                        });
                }   */
           };
           
          
        };
         //console.log(howMany);
         //console.log($scope.cartProducts);
       /// console.log($scope.realCart);
        var totAmnt = 0;
        //console.log($scope.cart[0].cartPrice);
        for(var x = 0; x < $scope.cart.length ;x++ )
        {
            totAmnt = totAmnt + $scope.cart[x].cartPrice;
        }
        //console.log(totAmnt);
        $scope.totalCart = [];
        
        $scope.totalCart[num] = totAmnt;
        console.log($scope.totalCart);
    });

    $scope.create = function(prod,quant)
    {
        var a = Number(quant);
        if(a > 0)
        {
            var AddToCart =
                {
                    cartQuantity: quant,
                    cartPrice: prod.price * quant,
                    custID: $scope.userDetails[0].custID,
                    barcode: prod.barcode
                };
                console.log(AddToCart);
                
                $http.get("http://localhost:8181/getinventoryItem/" +  prod.barcode).then(function(response)
                {
                    console.log(response);
                                                          
                });
                

                    $http.post('http://localhost:8181/saveCart',AddToCart).then(function(response)
                    {
                        console.log(response);
                        if(response.data.getcard_id !== 0)
                        {
                            alert(prod.prodName + " has been added to the cart");
                        }
                        else
                        {
                            alert(prod.prodName + " is already included in your cart");
                        }
                    });
        }
        else
        {
            alert("Please add more than one quantity to selected");
        }
            
    };
    
    $scope.delete = function(carts)
    {
        console.log(carts);
        
        var deleteCart ={
            barcode : carts.barcode,
            custID : $scope.userDetails[0].custID
        };
        
        $http.post('http://localhost:8181/deleteCart', deleteCart).then(function(response)
        {
            $scope.cart=response;
            console.log(response);
            if(response.data !== 0)
            {
                console.log("Cart deleted");
                alert("Cart deleted");
            }
            else
            {
                console.log("Cart couldnt delete successfully ");
                alert("Cart couldnt delete successfully");
            }
        });
    };
         
    $scope.confirmPayment = function(bank,payType,cardnum)
    {

        if(cardnum.toString().length != 16)
        {
            alert("Please ensure your credit card number is 16 digits");
        }
        else
        {
            if(bank === undefined)
            {
                alert("Please ensure you selected a bank");
            }
            else
            {
                if(payType === undefined)
                {
                    alert("Please ensure you selected a payment type");
                }
                else
                {
                    //alert($scope.totalCart[0]);
                    //alert($scope.userDetails[0].custID);
                    var today = new Date();
                    var dd = today.getDate();
                    var mm = today.getMonth()+1; //January is 0!
                    var yyyy = today.getFullYear();
                    
                    
                    var hour = today.get

                    if(dd<10) {
                        dd = '0'+dd
                    } 

                    if(mm<10) {
                        mm = '0'+mm
                    } 

                    today = mm + '/' + dd + '/' + yyyy;
                    
                    //Create JSON Format / "Object" for adding payment details
                    var AddPayment =
                    {
                        creditcardnum: cardnum,
                        bank: bank,
                        custID: $scope.userDetails[0].custID,
                        paydate: today,
                        paytype: payType
                    };
                    
                    //Create JSON Format / "Object" for adding order details
                    var AddOrder =
                    {
                        custID: $scope.userDetails[0].custID,
                        orderdate: today,
                        total: $scope.totalCart[0]
                    };
                    
                    //POST method for sending data to /savepayment URL , sent with JSON format/ "Object"
                    $http.post('http://localhost:8181/savepayment',AddPayment).then(function(response)
                    {
                        if(response.data.getcard_id !== 0)
                        {
                            alert("Thank you for providing your payment details");
                            
                                //POST method for sending data to /saveOrder URL , sent with JSON format/ "Object"
                                $http.post('http://localhost:8181/saveOrder',AddOrder).then(function(response)
                                {
                                    if(response.data.getcard_id !== 0)
                                    {
                                        alert("Thank you your order is complete");
                                        //Get the Order you've just added
                                        var latestOrder ;
                                        for(var i = 0; i < $scope.orders.length ;i++)
                                        {
                                            latestOrder = $scope.orders[i].orderno;

                                        }
                                          
                                        for(var i = 0; i <= $scope.cart.length ;i++)
                                        {
                                            //Create JSON Format / "Object" for adding salesitem details
                                            var salesItem ={
                                            orderno : latestOrder + 1,
                                            custid:$scope.cart[i].barcode
                                            };
                                            console.log(salesItem);
                                            //POST method for sending data to /savesalesitem URL , sent with JSON format/ "Object"
                                            $http.post('http://localhost:8181/savesalesitem',salesItem).then(function(response)
                                                   {
                                                       if(response.data.getcard_id !== 0)
                                                       {
                                                           alert("Done");
                                                           
                                                           //Create JSON Format / "Object" for adding Customer cart details
                                                           var deleteCartByCust =
                                                           {
                                                               custID : $scope.userDetails[0].custID
                                                           }
                                                           
                                                           console.log(deleteCartByCust);
                                                           //POST method for sending data to /deleteCartByCust URL , sent with JSON format/ "Object"
                                                           $http.post('http://localhost:8181/deleteCartByCust', deleteCartByCust).then(function(response)
                                                            {
                                                                $scope.cart=response;
                                                                if(response.data !== 0)
                                                                {
                                                                    alert("Cart deleted");
                                                                }
                                                                else
                                                                {
                                                                    alert("Cart couldnt delete successfully");
                                                                }
                                                            });
                                             
                                                       }
                                                       else
                                                       {
                                                           alert("Not Done");
                                                       }
                                                   });
                                        }
                                        
                                        
                                    }
                                    else
                                    {
                                        alert("ERROR- Order details invalid");
                                    }
                                });
                        }
                        else
                        {
                            alert("ERROR- Payment details invalid");
                        }
                    });
                    
                }
                
            }
        }
        
    };
   
    //Function to delete seleced product 
    $scope.deleteProd = function(product)
    {
        var barcode = product.barcode;
        
        //DELETE method for sending data to /deleteProduct URL , sent with JSON format/ "Object"
        $http.delete('http://localhost:8181/deleteProduct/' + barcode).then(function(response)
        {
            $scope.cart=response;
            if(response.data !== 0)
            {
                alert("Product: " + product.prodName + "has been sucessfully deleted.");
            }
            else
            {
                alert("Product: " + product.prodName + "has been NOT sucessfully deleted.");
            }
        });
    };
    
    //GET method for retrieving data to /getCust URL 
    $http.get("http://localhost:8181/getCust").then(function(response)
    {
        $scope.cust = response.data;
        
        //GET method for retrieving data to /getCustById URL 
        $http.get("http://localhost:8181/getCustById").then(function(response)
        {
            $scope.editCust = [];
            $scope.editCust = response.data;
        });
            
    });
    
    //Function to update customer details
    $scope.updateCust = function(email, fname, lname ,cellno , idno , group)
    {
        var n; 
        //Catch any text field mistakes from user
        if(email === undefined)
        {
            alert("Please enter your old/new email");
        }
        else
        {
            n = email.indexOf("@");
            
            if(n == "-1")
            {
                alert("Invalid email! - HINT : Missing '@' character");
            }
            else
            {
                if(fname === undefined)
                {
                    alert("Please enter your first name");
                }
                else
                {
                    if(lname === undefined)
                    {
                        alert("Please enter your Last name");
                    }
                    else
                    {
                        if(cellno.toString().length == 10 || cellno === undefined)
                        {
                                //Create JSON Format / "Object" for adding update customer details
                                var UpdateCust =
                                {
                                    custID : $scope.userDetails[0].custID,
                                    name: fname,
                                    lastName: lname,
                                    email: email,
                                    cellno : cellno,
                                    idNo : idno,
                                    title : group,
                                    active : 1,
                                    password : $scope.userDetails[0].password
                                };
                                
                                //GET method for insert data to /updateCust URL , sent with JSON format/ "Object"
                                $http.put("http://localhost:8181/updateCust" ,UpdateCust).then(function(response)
                                {
                                    alert("Sucessfully edited your profile.");
                                });
                        }
                        else
                        {
                            alert("Please ensure your cell numbers are 10 numbers or more");
                        } 
                    }
                }
            }
        }
    };
    
    //Function to update product details
    $scope.updateProd = function(selectedProduct,productName,productPrice,productDescription, selectedCat)
    {
        //GET method for insert data to /getCustByName URL , sent with JSON format/ "Object"
        $http.get("http://localhost:8181/getCustByName/" + selectedProduct).then(function(response)
        {
            $scope.prodDetails = response.data;
            
            //GET method for insert data to /getCatByName URL , sent with JSON format/ "Object"
            $http.get("http://localhost:8181/getCatByName/" + selectedCat).then(function(response)
            {
                $scope.catDetails = response.data; 
            });
            
            
            var UpdateProd ={
                barcode : $scope.prodDetails.barcode,
                price : productPrice,
                categoryID : $scope.catDetails.categoryID,
                prodName : productName,
                prodInfo : productDescription
            };
            
            console.log(UpdateProd);
            
            $http.put("http://localhost:8181/updateProd" ,UpdateProd).then(function(response)
            {
                alert("Sucessfully edited your product " + productName + ".");
            }); 
        });  
    };
        $scope.deleteOrder = function(order)
        {
            console.log(order);

            $http.post('http://localhost:8181/deleteOrder/' + order.orderno).then(function(response)
            {
                console.log(response);
                if(response.data !== 0)
                {
                    alert("Order deleted");
                }
                else
                {
                    alert("Order couldnt be delete successfully");
                }
            });
        };
        
        $scope.addAddress = function(state,addressname,streetnumber,streetname)
        {
            if(state === undefined)
            {
                alert("Please enter Province or state");
            }
            else
            {
                if(addressname === undefined)
                {
                    alert("Please enter your Address Name");
                }
                else
                {
                    if(streetnumber === undefined)
                    {
                        alert("Please enter your Street Number");
                    }
                    else
                    {
                        if(streetnumber === undefined)
                        {
                            alert("Please enter your Street Name");
                        }
                        else
                        {
                            var AddLocation =
                            {
                                addressName: addressname + " " + streetname + " " + streetnumber,
                                streetNo:streetnumber,
                                streetName : streetname,
                                state : state,
                                country: "South Africa",
                                custID: $scope.userDetails[0].custID
                            };


                        $http.post('http://localhost:8181/savelocation', AddLocation).then(function(response)
                        {
                            console.log(response);
                            if(response.data !== 0)
                            {
                                alert("Address has been set");
                            }
                            else
                            {
                                alert("Address has not been set");
                            }
                        });
                        }
                    }
                }
                
            }
            
            
        };
    
});

