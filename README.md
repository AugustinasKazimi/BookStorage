1. There are 3 different kind of books a client can reach by a barcode: books, antique books and journals. Moreover, books, antique books and journals could be added by a client. For each type of books there were created a controller, two classes of objects, service class and service implementation class where all the code is set up.
2. A client can also update books. In each controller there is a possibility to get the price of the books, antique books and journals by using a barcode.
3. Unit test to get added book is also added.
4. Restrictions added to the objects: not null, size.
5. Before calling the endpoint it should be added type of the book in the URL. The example: if you want to call and endpoint which gets created book the URL should look like this: "http://localhost:8080/{bookType}/{barcode}".
