<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>CRUD of Cities</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles.css" media="screen">
    <script src='main.js'></script>
</head>
<body>
    <div class="container-fluid">
                <div class="jumbotron mt-5">
                    <h1>Cities Manager</h1>
                    <p>A solution to CREATE, REVIEW, UPDATE and DELETE cities</p>
                </div>
                <form action="/create" method="POST">
                    <div class="form-group">
                        <label for="name">City:</label>
                        <input  name="name" type="text" class="form-control" placeholder="Enter the city name" id="name">
                    </div>
                    <div class="form-group">
                        <label for="state">State:</label>
                        <input name="state" type="text" class="form-control" placeholder="Enter the state name the the name belongs" id="state">
                    </div>
                    <button type="submit" class="btn btn-primary">CREATE CITY</button>
                </form>
                <table class="table table-striped table-hover mt-5">
                    <thead class="thead-dark">
                        <tr>
                            <th>Name</th>
                            <th>State</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody
                    <#list listOfCities as city>
                        <tr>
                            <td>${city.name}</td>
                            <td>${city.state}</td>
                            <td class="d-flex d-justify-content-center">
                                <a class="btn btn-warning mr-4">UPDATE</a>
                                <a class="btn btn-danger" href="/delete?name=${city.name}&state=${city.state}">DELETE</a>
                            </td>
                        </tr>
                    </#list> 
                    </tbody>                   
                </table>                
    </div>
    <div class="d-flex justify-content-center aling-items-center text-white bg-dark">
        <div class="text-center mt-2 mb-2 font-italic">Developed by Rafael de Luca</div>
    </div>     
</body>
</html>