@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("deleteId");

        boolean deleted = bookManager.deleteBook(bookId);
        if (deleted) {
            response.sendRedirect("index.html");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found");
        }
    }
}
