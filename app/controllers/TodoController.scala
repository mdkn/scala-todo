package controllers

import javax.inject.Inject

import models.TodoDao
import play.api.mvc._

/**
  * Created by madokan on 5/6/16.
  */
class TodoController @Inject()(todoDao: TodoDao) extends Controller {
  def index = Action {
    Ok(views.html.todo())
  }

  def add = ???

  def list = ???
}
