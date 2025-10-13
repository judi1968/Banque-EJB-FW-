using Pret.Data;
using Pret.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Pret.Services
{
    public class MouvementPretService
    {
        private readonly AppDbContext _context;

        public MouvementPretService(AppDbContext context)
        {
            _context = context;
        }

        // 🔹 Récupérer tous les mouvements
        public async Task<List<MouvementPret>> GetAllAsync()
        {
            return await _context.MouvementPret.ToListAsync();
        }

        // 🔹 Ajouter un mouvement
        public async Task<MouvementPret> AddAsync(MouvementPret mouvement)
        {
            _context.MouvementPret.Add(mouvement);
            await _context.SaveChangesAsync();
            return mouvement;
        }
    }
}
