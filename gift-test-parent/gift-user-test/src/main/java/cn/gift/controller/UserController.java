package cn.gift.controller;

import cn.gift.service.IUserService;
import cn.gift.domain.User;
import cn.gift.query.UserQuery;
import cn.gift.util.AjaxResult;
import cn.gift.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public IUserService userService;


    /**
     * 保存和修改公用的
     * @param user  传递的实体
     * @return Ajaxresult转换结果
     */
    @PutMapping
    public AjaxResult addOrUpdate(@RequestBody User user){
        try {
            if( user.getId()!=null)
                userService.updateById(user);
            else
                userService.insert(user);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }
    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @DeleteMapping(value="/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            userService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }
	
    //获取用户
    @GetMapping("/{id}")
    public AjaxResult get(@PathVariable("id")Long id)
    {
        try {

            User user = userService.selectById(id);
            return AjaxResult.me().setResultObj(user);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("获取一个失败！"+e.getMessage());
        }
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @GetMapping
    public AjaxResult list(){

        try {
            List< User> list = userService.selectList(null);
            return AjaxResult.me().setResultObj(list);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("获取所有失败！"+e.getMessage());
        }
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @PostMapping("/list")
    public AjaxResult json(@RequestBody UserQuery query)
    {
        Page<User> page = new Page<User>(query.getPage(),query.getRows());
        page = userService.selectPage(page);
        PageList pageList = new PageList<User>(page.getTotal(),page.getRecords());
        return AjaxResult.me().setResultObj(pageList);
    }
}
