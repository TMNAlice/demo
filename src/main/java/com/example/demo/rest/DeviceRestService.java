package com.example.demo.rest;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.DeviceService;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;


@RestController
@RequestMapping("/")
public class DeviceRestService {

        @Autowired
        private DeviceService deviceService;

        @RequestMapping(value = "/la", method = RequestMethod.GET)
        public ResponseEntity<Object> browse() {
            return ResponseEntity.ok(deviceService.listAll());
        }

        @RequestMapping(value = "/find", method = RequestMethod.GET)
        public ModelAndView found(@RequestParam Integer id) {
            ModelAndView mav = new ModelAndView("device");
            mav.addObject("device",deviceService.findById(id));
            return mav;
        }

        @RequestMapping(value = "/delete", method = RequestMethod.GET)
        public ModelAndView delete(@RequestParam Integer id, @AuthenticationPrincipal Principal principal ) {
            if (principal == null){
                throw new ForbiddenException();
            }
            //MyLogin activeUser = (MyLogin) ((Authentication) principal).getPrincipal();
            //activeUser.getUsername();
            deviceService.deleteById(id);
            ModelAndView mav = new ModelAndView("device");
            mav.addObject("device",deviceService.listAll());
            return mav;
        }

        @RequestMapping(value = "/add", method = RequestMethod.GET)
        public ModelAndView add(@RequestParam Integer id, @RequestParam Integer number, @RequestParam String name, @AuthenticationPrincipal Principal principal) {
            if (principal == null){
                throw new ForbiddenException();
            }
            deviceService.add(id, number, name);
            ModelAndView mav = new ModelAndView("device");
            mav.addObject("device",deviceService.listAll());
            return mav;
        }

        @RequestMapping (value = "/gen", method = RequestMethod.GET)
        public ModelAndView gen(@RequestParam Integer id){
            QRCodeGenerator qrgentr = new QRCodeGenerator();
            try {
                qrgentr.generateQRCodeImage ("192.168.42.12/find?id="+id, 320, 320, "./MyQRCode.png");
            } catch (WriterException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ModelAndView mav = new ModelAndView("device");
            mav.addObject("device",deviceService.listAll());
            return mav;
        }

        /*@RequestMapping(value = "/mody", method = RequestMethod.GET)
    public ResponseEntity<Object> mody(@RequestParam Integer id, @RequestParam Integer number, @RequestParam String name, @AuthenticationPrincipal Principal principal) {
        if (principal == null){
            throw new ForbiddenException();
        }
        deviceService.mody(id, number, name);
        return ResponseEntity.ok(deviceService.listAll());
    }*/

}
