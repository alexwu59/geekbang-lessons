package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/register")
public class RegisterController implements PageController {


    @Override
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        UserService  userService = (UserService)request.getServletContext().getAttribute("userService");
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phone);
        userService.deregister(user);
        request.setAttribute("name",userName);
        request.setAttribute("password",password);

        List<User> all = userService.getAll();

        request.setAttribute("users",all);


        return "success.jsp";
    }
}
