var app = angular.module('pnpModuleAddProd',[]);
    //app.config(function($routeProvider, $locationProvider))

app.controller("AddProductController",function($http,$scope,$location,$rootScope,$filter)
{
    $scope.image = null;
    $http.defaults.headers.post["Content-Type"] = "application/json";

    var url = '/addProduct';
    var imageCopy = null;
    var image = null;
    
  
    var handleImageSelect = function(evt)
    {
        var files = evt.target.files;
        var file = files[0];
        if(files && file)
        {
            var reader = new FileReader();
            reader.onload = function(readerEvt)
            {
                var binaryString = readerEvt.target.result;
                imageCopy = btoa(binaryString);
                image = 'data:image/octet-stream;base64,' + imageCopy;
                $scope.image = image;
            };
            
            reader.readAsBinaryString(file);
        } 
    };
    
    if(window.File && window.FileReader && window.FileList && window.Blob)
    {
        document.getElementById("filePickerImage").addEventListener('change', handleImageSelect,false);
    }
    else
    {
        alert('Image/File is not supported');
    }
    
    $scope.saveProd = function(group,quantity)
    {
        
        var name = $scope.name;
        console.log(quantity);
        console.log(group);
        var groupNum;
        
        if(group == "Food cupboard")
        {
            groupNum = 2;
        }
        else if (group == "Frozen food")
        {
            groupNum = 3;
        }
        else if (group == "Convenience meals")
        {
            groupNum = 4;
        }
        else if (group == "Beverages")
        {
            groupNum = 5;
        }
        else if (group == "Baby")
        {
            groupNum = 6;
        }
        else if (group == "Health and Beauty")
        {
            groupNum = 7;
        }
        else if (group == "Electronics and Office")
        {
            groupNum = 8;
        }
        else if (group == "Home and Outdoor")
        {
            groupNum = 9;
        }
        else if (group == "Household cleaning")
        {
            groupNum = 10;
        }
      
        $scope.groupNum = groupNum;
        
        console.log($scope.groupNum);
        
        var products = {
            price: $scope.price,
            prodInfo: $scope.info,
            prodName: $scope.name,
            prodImage: $scope.image,
            categoryID: $scope.groupNum
        };
        console.log(products);
        
        $http.post(url,products
        ).then(successCallback, errorCallback);
            function  successCallback(response)
            {
                alert("Product Added Sucessfully");
                console.log(products);
                
                $http.get("http://localhost:8181/getProducts").then(function(response)
                {
                    console.log(response.data);
                    $scope.products = response.data;
                    
                    for(var i = 0; i < $scope.products.length;i++)
                    {
                        latestProd = $scope.products[i].barcode;
                    }
                    console.log(latestProd);
                    
                    var InventoryItem =
                            {
                                barcode : latestProd,
                                quantity : quantity
                            };
                    
                    $http.post('http://localhost:8181/addInventory',InventoryItem).then(function(response)
                    {
                        console.log(response);
                        if(response.data.getcard_id !== 0)
                        {
                            alert("Done");
                        }
                        else
                        {
                            console.log("Order not added");
                            alert("Not Done");  
                        }
                   });
                    
                });
               
            };
            function errorCallback(response)
            {
                console.log(response);
                alert("Failed to add products");
            };
    };
    
    
    
});

