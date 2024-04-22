package syc.study.javabase.build.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 验收单配置表 前端控制器
 * </p>
 *
 * @author syc
 * @since 2024-04-22
 */
@RestController
@RequestMapping("/111")
public class FactoryBuildStepAcceptSheetConfigController {

    @GetMapping("/uploadExcel")
    public void uploadExcel(@RequestParam(value = "stationNum")String stationNum, @RequestParam(value = "file",required = false) MultipartFile file){

    }

}
