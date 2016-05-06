package controllers

import javax.inject.Inject

import models.TodoDao
import play.api.mvc._

import scala.concurrent.ExecutionContext

/**
  * Created by madokan on 5/6/16.
  */
class TodoController @Inject()(todoDao: TodoDao)(implicit ec: ExecutionContext) extends Controller {
  def index = Action.async { implicit request =>
    todoDao.get map (todos => Ok(views.html.todo(todos)))
  }

  def add = ???
}
