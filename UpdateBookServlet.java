@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("updateId");
        String newTitle = request.getParameter("newTitle");
        String newAuthor = request.getParameter("newAuthor");
        String newStatus = request.getParameter("newStatus");

        boolean updated = bookManager.updateBook(bookId, newTitle, newAuthor, newStatus);
        if (updated) {
            response.sendRedirect("index.html");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found");
        }
    }
}
