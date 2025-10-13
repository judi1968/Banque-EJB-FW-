using Depot.Models;
using Depot.Services;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Depot.Controllers
{
    [ApiController]
    [Route("api/montant_personne")]
    public class MontantPersonneController : ControllerBase
    {
        private readonly MontantPersonneService _service;

        public MontantPersonneController(MontantPersonneService service)
        {
            _service = service;
        }

        // 🔹 Récupérer tous les montants
        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var montants = await _service.GetAllMontantsAsync();
            return Ok(montants);
        }

        // 🔹 Récupérer le montant d'une personne par ID
        // [HttpGet("{idPersonne}")]
        // public async Task<IActionResult> GetById(int idPersonne)
        // {
        //     var montant = await _service.GetMontantByIdAsync(idPersonne);
        //     if (montant == null)
        //         return NotFound();
        //     return Ok(montant);
        // }
    }
}
