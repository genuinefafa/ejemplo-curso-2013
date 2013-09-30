package foo.curso.alumno;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import foo.curso.entities.Alumno;
import foo.curso.models.AlumnoForm;

@Controller
@RequestMapping(value="/alumno/**")
public class AlumnoController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		
		ArrayList<Alumno> alumnos = AccessAlumnoDAO.getInstance().getAll();
		
		//obtener lista de alumnos
		mav.getModelMap().addAttribute("alumnos", alumnos);
		
		return mav;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute AlumnoForm alumnoForm){
		ModelAndView mav = new ModelAndView("redirect:index");
		
		/*GregorianCalendar calendario = new GregorianCalendar();
		calendario.set(Integer.parseInt(alumnoForm.getAño()), Integer.parseInt(alumnoForm.getMes())-1, Integer.parseInt(alumnoForm.getDia()));
		Date nacimiento = calendario.getTime();*/
		
		AccessAlumnoDAO.getInstance().crear(alumnoForm.crearAlumno());
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public ModelAndView editar(@RequestParam int legajo){
		ModelAndView mav = new ModelAndView();
		
		Alumno alumno = AccessAlumnoDAO.getInstance().get(legajo);
		mav.getModelMap().addAttribute("alumno", alumno);
		
		return mav;
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public ModelAndView editar(@ModelAttribute AlumnoForm alumnoForm){
		ModelAndView mav = new ModelAndView("redirect:index");
		
		Alumno alumno = AccessAlumnoDAO.getInstance().get(alumnoForm.getLegajo());
		alumno.setNombre(alumnoForm.getNombre());
		alumno.setApellido(alumnoForm.getApellido());
		
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.set(Integer.parseInt(alumnoForm.getAno()), Integer.parseInt(alumnoForm.getMes())-1, Integer.parseInt(alumnoForm.getDia()));
		Date nacimiento = calendario.getTime();
		
		alumno.setNacimiento(nacimiento);
		
		AccessAlumnoDAO.getInstance().save(alumno);
		return mav;
	}
	
	@RequestMapping(value="/eliminar", method=RequestMethod.POST)
	public ModelAndView eliminar(@ModelAttribute AlumnoForm alumnoForm){
		ModelAndView mav = new ModelAndView("redirect:index");
		
		AccessAlumnoDAO.getInstance().eliminar(alumnoForm.getLegajo());
		return mav;
	}
	
	
}
