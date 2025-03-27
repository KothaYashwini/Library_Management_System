@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchInput = request.getParameter("searchInput");

        Book book = bookManager.searchBook(searchInput);
        if (book != null) {
            response.getWriter().write(book.toString());  // Output the book details as a response
        } else {
            response.getWriter().write("Book not found");
        }
    }
}
