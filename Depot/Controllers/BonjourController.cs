using Microsoft.AspNetCore.Mvc;

namespace Depot.Controllers
{
    [ApiController]
    [Route("api/bonjour")]
    public class BonjourController : ControllerBase
    {
        [HttpGet]
        public IActionResult GetBonjour()
        {
            var message = new { message = "Bonjour" };
            return Ok(message); // renvoie {"message":"Bonjour"} en JSON
            
        }
    }
}
