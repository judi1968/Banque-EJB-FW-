using Microsoft.EntityFrameworkCore;
using Pret.Data;
using Pret.Models;

namespace Pret.Services
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
