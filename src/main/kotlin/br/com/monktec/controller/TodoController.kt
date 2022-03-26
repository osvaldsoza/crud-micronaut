package br.com.monktec.controller

import br.com.monktec.model.Todo
import br.com.monktec.repository.TodoRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post


@Controller("/todos")
class TodoController(private val todoRepository: TodoRepository) {

//    @Inject
//    private val todoRepository: TodoRepository? = null

    @Get
    fun getTodos(): List<Todo> {
        return todoRepository.findAll()
    }

    @Post
    fun addTodo(todo: Todo): HttpResponse<Todo> {
        var todo = todoRepository.save(todo)

        return HttpResponse.created(todo);
    }
}