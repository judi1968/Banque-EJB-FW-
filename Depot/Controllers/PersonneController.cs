using Microsoft.AspNetCore.Mvc;
using Depot.Models;
using Depot.Services;

namespace Depot.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class PersonneController : ControllerBase
    {
        private readonly PersonneService _service;

        public PersonneController(PersonneService service)
        {
            _service = service;
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var personnes = await _service.GetAllPersonnesAsync();
            return Ok(personnes);
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] Personne personne)
        {
            var created = await _service.AddPersonneAsync(personne);
            return Ok(created);
        }
    }
}
