@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");
        String status = request.getParameter("status");

        if (bookId != null && !bookId.trim().isEmpty() && title != null && !title.trim().isEmpty() &&
            author != null && !author.trim().isEmpty() && (status.equals("Available") || status.equals("Checked Out"))) {
            
            Book book = new Book(bookId, title, author, genre, status);
            bookManager.addBook(book);
            response.sendRedirect("index.html");  // Redirect back to form
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input fields");
        }
    }
}
