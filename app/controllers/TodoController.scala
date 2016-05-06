package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by madokan on 5/6/16.
  */
class TodoController extends Controller {
  def index = Action {
    Ok(views.html.todo())
  }
}
