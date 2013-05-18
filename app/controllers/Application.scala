package controllers

import play.api.mvc._
import freemarker.template.Configuration
import freemarker.template.Template
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

object Application extends Controller {

  val config = new Configuration()

  def index = Action {
    Ok(views.html.index())
  }

  def templateResult(source: String) = Action {

    var result: String = null
    try {
      val reader = new InputStreamReader(new ByteArrayInputStream(source.getBytes))
      val template = new Template("sample", reader, config)

      result = FreeMarkerTemplateUtils.processTemplateIntoString(template, null)

    } catch {
      case e: Exception => result = e.getMessage()
    }

    Ok(result)
  }
}