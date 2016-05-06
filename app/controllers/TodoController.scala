package controllers

import javax.inject.Inject

import models.{Todo, TodoDao}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

import scala.concurrent.{Future, ExecutionContext}

/**
  * Created by madokan on 5/6/16.
  */
case class AddTodoForm(text: String)

class TodoController @Inject()(todoDao: TodoDao)(implicit ec: ExecutionContext) extends Controller {
  def index = Action.async { implicit request =>
    todoDao.get map (todos => Ok(views.html.todo(todos)))
  }

  val addTodoForm = Form(
    mapping(
      "text" -> text
    )(AddTodoForm.apply)(AddTodoForm.unapply)
  )

  def add = Action.async { implicit request =>
    addTodoForm.bindFromRequest.fold(
      errors => Future.successful(BadGateway),
      form => {
        todoDao.store(Todo(None, form.text, 0)) map (_ => Redirect(routes.TodoController.index()))
      }
    )
  }
}
