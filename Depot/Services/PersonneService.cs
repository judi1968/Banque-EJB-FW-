using Microsoft.EntityFrameworkCore;
using Depot.Data;
using Depot.Models;

namespace Depot.Services
{
    public class PersonneService
    {
        private readonly AppDbContext _context;

        public PersonneService(AppDbContext context)
        {
            _context = context;
        }

        public async Task<List<Personne>> GetAllPersonnesAsync()
        {
            return await _context.Personne.ToListAsync();
        }

        public async Task<Personne> AddPersonneAsync(Personne p)
        {
            _context.Personne.Add(p);
            await _context.SaveChangesAsync();
            return p;
        }
    }
}
