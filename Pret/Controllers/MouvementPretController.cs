using Microsoft.AspNetCore.Mvc;
using Pret.Models;
using Pret.Services;
using System.Threading.Tasks;

namespace Pret.Controllers
{
    [ApiController]
    [Route("api/mouvement_pret")]
    public class MouvementPretController : ControllerBase
    {
        private readonly MouvementPretService _service;

        public MouvementPretController(MouvementPretService service)
        {
            _service = service;
        }

        // 🔹 Récupérer tous les mouvements de prêt
        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var mouvements = await _service.GetAllAsync();
            return Ok(mouvements);
        }

        // 🔹 Ajouter un mouvement de prêt
        [HttpPost]
        public async Task<IActionResult> Create([FromBody] MouvementPret mouvement)
        {
            if (mouvement == null)
                return BadRequest("Les données du mouvement sont manquantes.");

            var created = await _service.AddAsync(mouvement);
            return Ok(created);
        }
    }
}
