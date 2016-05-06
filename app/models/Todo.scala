package models

import javax.inject.Inject

import play.api.db.slick._
import slick.driver.JdbcProfile

/**
  * Created by madokan on 5/6/16.
  */
case class Todo(id: Option[Long], text: String, isDone: Int)

class TodoDao @Inject()(val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._

  class TodoTable(tag: Tag) extends Table[Todo](tag, "todo") {
    def id = column[Long]("id")
    def text = column[String]("text")
    def isDone = column[Int]("is_done")
    def * = (id?, text, isDone) <> (Todo.tupled, Todo.unapply)
  }

  val table = TableQuery[TodoTable]

  def store = ???

  def get = ???
}
