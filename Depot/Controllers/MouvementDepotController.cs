using Microsoft.AspNetCore.Mvc;
using Depot.Models;
using Depot.Services;

namespace Depot.Controllers
{
    [ApiController]
    [Route("api/mouvement_depot")]
    public class MouvementDepotController : ControllerBase
    {
        private readonly MouvementDepotService _service;

        public MouvementDepotController(MouvementDepotService service)
        {
            _service = service;
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var mouvements = await _service.GetAllMouvementsAsync();
            return Ok(mouvements);
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] MouvementDepot mouvement)
        {
            var created = await _service.AddMouvementAsync(mouvement);
            return Ok(created);
        }
    }
}
