<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>CRUD of Cities</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src='main.js'></script>
</head>
<body>
    <div class="container-fluid">
                <div class="jumbotron mt-5">
                    <h1>Cities Manager</h1>
                    <p>A solution to CREATE, REVIEW, UPDATE and DELETE cities</p>
                </div>
                <form>
                    <div class="form-group">
                        <label for="name">City:</label>
                        <input type="text" class="form-control" placeholder="Enter the city name" id="name">
                    </div>
                    <div class="form-group">
                        <label for="state">State:</label>
                        <input type="text" class="form-control" placeholder="Enter the state name the the name belongs" id="state">
                    </div>
                    <button type="submit" class="btn btn-primary">CREATE CITY</button>
                </form>
                <table class="table table-striped table-houver mt-5">
                    <thead class="thead-light">
                        <tr>
                            <th>Name</th>
                            <th>State</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Porto Alegre</td>
                            <td>Rio Grande do Sul</td>
                            <td class="d-flex d-justify-content-center">
                                <a class="btn btn-warning mr-4">UPDATE</a>
                                <a class="btn btn-danger">DELETE</a>
                            </td>
                        </tr>
                        <tr></tr>
                            <td>Salvador</td>
                            <td>Bahia</td>
                            <td class="d-flex d-justify-content-center">
                                <a class="btn btn-warning mr-4">UPDATE</a>
                                <a class="btn btn-danger">DELETE</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
    </div>
    
</body>
</html>