package edu.mum.cs.cs425.eRegistrar.controller;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.service.iService.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller()
@RequestMapping
public class StudentController {
   private IStudentService iStudentService;

    @Autowired
    public StudentController(IStudentService iStudentService){
    this.iStudentService =  iStudentService;
    }

    @GetMapping(value = {"/student/list","/"})
    public String getAll(Model model){
        List<Student> students = iStudentService.getAll();
        model.addAttribute("size",students.size());
        model.addAttribute("students",students);
        return "student/list";
    }
    @PostMapping(value="/student/save")
    public String save(@Valid @ModelAttribute("student") Student student,Model model){
        Student st = iStudentService.save(student);
        return "redirect:/student/list";
    }
    @GetMapping(value = "/student/new")
    public  String createView(Model model){
        model.addAttribute("student",new Student());
        return "student/edit";
    }
    @GetMapping(value = "/student/edit/{id}")
    public String editView(@PathVariable Long id,Model model){
        Student student = iStudentService.findOne(id);
        model.addAttribute("student",student);
        return "student/edit";
    }
    @GetMapping(value = "/student/delete/{id}")
    public String delete(@PathVariable Long id,Model model){
        iStudentService.delete(id);
        return "redirect:/student/list";
    }

    @GetMapping(value="/student/search")
    public String getProduct(Model model,
                             @ModelAttribute("student") Student student,
                             BindingResult result) {
        List<Student> st = this.iStudentService.searchStudents(student);
        if(st.size() == 0){
            return "redirect:/student/list";
        }
        model.addAttribute("students", st);
        return "student/list";
    }

    @GetMapping(value="/student/key")
    public String getStudentsBykeword(Model model,String keyWord) {
//        List<Student> st = this.iStudentService.searchStudents(student);

        if(keyWord != null){

            List<Student> st = iStudentService.findByKeyWord(keyWord);
            model.addAttribute("size",st.size());
            model.addAttribute("students",st);
        }else{
            List<Student> st = this.iStudentService.getAll();
            model.addAttribute("students",st);
        }
//        model.addAttribute("students", st);
        return "student/list";
    }

    @GetMapping(value="/keys")
    public String getStudentsBykewordss(Model model,String keyWord) {
       List<Student> sts = iStudentService.getAll();
//        model.addAttribute("students",sts);
        if(keyWord != null){
            List<Student> st = iStudentService.findByKeyWord(keyWord);
            model.addAttribute("students",iStudentService.findByKeyWord(keyWord));
        }else{
            List<Student> st = this.iStudentService.getAll();
            model.addAttribute("students",st);
        }
//        model.addAttribute("students", st);
        return "student/list";
    }


}
